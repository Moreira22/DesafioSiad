import * as React from "react";
import { cn } from "@/lib/utils";
import { Button } from "@/components/ui/button";
import { Form, FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage } from "@/components/ui/form";
import * as o from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod"
import { toast } from "@/components/ui/use-toast";
import { Juridico } from "@/model/juridico";
import { usejuridico } from "@/hooks/empresaAuth";
import { Input } from "@/components/ui/input";


interface UserAuthFormProps extends React.HTMLAttributes<HTMLDivElement> { }

export function Form({ className, ...props }: UserAuthFormProps) {
    const [isLoading, setIsLoading] = React.useState<boolean>(false);
    const [juridico, setJuridico] = React.useState<Juridico>();
    const { PostJuridico } = usejuridico();

    
    const formSchema = o.object({
        nome: o.string().min(3, {
            message: "Campo `Descrição` precisa ter mais que 3 caracteres.",
        }),
        cnpj: o.string().min(3, {
            message: "Campo `link` precisa ter mais que 3 digitos.",
        }),
        dataNascimento: o.number().min(3, {
            message: "Campo `link` precisa ter mais que 3 digitos.",
        }),    
    })

    const form = useForm<o.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        defaultValues: {
            nome: "",
            cnpj: "",
            dataNascimento: 0,
        },
    })

    async function onSubmit(values: o.infer<typeof formSchema>) {
        const value = {
            "nome": values.nome,
            "cnpj": values.cnpj,
            "dataNascimento": values.dataNascimento,
        }
        setIsLoading(true);

        try {
            await PostJuridico(value);
        } catch (error) {
            console.error("Erro ao fazer login", error);
            toast({
                title: "Erro inesperado!",
                description: "Não foi cadastra empresa",
                variant: "destructive"
            })
        } finally {
            setIsLoading(false);
        }
    }

    return (
        <div className={cn("grid gap-6", className)} {...props}>
            <Form {...form}>
                <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-1">

                    <FormField
                        control={form.control}
                        name="descricao"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel className="text-[#00000]">Descrição:</FormLabel>
                                <FormControl>
                                    <Input className="border border-[#A7A7A7]" placeholder="Descricao da rota" {...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>
                        )}
                    />
                    <FormField
                        control={form.control}
                        name="url"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel className="text-[#00000]">Link:</FormLabel>
                                <FormControl>
                                    <Input className="border border-[#A7A7A7]" placeholder="Link de acesso a api" {...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>
                        )}
                    />
                    <div className="flex flex-row justify-end p-6 gap-3">
                        
                        <Button className="  bg-[#10476E] flex float-end border  border-[#A7A7A7] h-10 w-50% rounded-full px-6 py-2 text-sm ring-offset-background file:border-0 fi
                        le:bg-transparent file:text-sm file:font-medium  focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 
                        disabled:cursor-not-allowed disabled:opacity-50 gap-3" type="submit">Adicionar Link <CirclePlus /></Button>
                    </div>
                </form>
            </Form>
        </div>
    )
}