import * as React from "react";
import { cn } from "@/lib/utils";
import { Button } from "@/components/ui/button";
import { Label } from "@/components/ui/label";
import { Github, Loader } from "lucide-react";
import { Juridico } from "@/model/juridico";
import { usejuridico } from "@/hooks/empresaAuth";
import { Input } from "@/components/ui/input";


interface UserAuthFormProps extends React.HTMLAttributes<HTMLDivElement> { }

export function UserAuthForm({ className, ...props }: UserAuthFormProps) {
    const [isLoading, setIsLoading] = React.useState<boolean>(false);
    const [juridico, setJuridico] = React.useState<Juridico>();
    const { getJuridico } = usejuridico();

    async function onSubmit(event: React.SyntheticEvent) {
        event.preventDefault();
        setIsLoading(true);

        try {
            await getJuridico(juridico);
        } catch (error) {
            console.error("Erro ao fazer login", error);
        } finally {
            setIsLoading(false);
        }
    }

    return (
        <div className={cn("grid gap-6", className)} {...props}>
            <form onSubmit={onSubmit}>
                <div className="grid gap-2">
                    <div className="grid gap-5">
                        <Label htmlFor="email">
                            Login
                        </Label>
                        <Input
                            id="email"
                            placeholder="nome@exemplo.com"
                            type="email"
                            autoCapitalize="none"
                            autoComplete="email"
                            autoCorrect="off"
                            disabled={isLoading}
                            onChange={(e) => setJuridico({ ...usuario, email: e.target.value })}
                        />
                        <Label htmlFor="senha">
                            Senha
                        </Label>
                        <Input
                            id="senha"
                            type="password"
                            autoCapitalize="none"
                            autoComplete="current-password"
                            autoCorrect="off"
                            disabled={isLoading}
                            onChange={(e) => setJuridico({ ...usuario, senha: e.target.value })}
                        />
                    </div>
                    <div className="text-right text-primary font-medium">
                        <p>Esqueci a minha senha</p>
                    </div>
                    <Button disabled={isLoading} className="mt-5">
                        {isLoading && (
                            <Loader className="mr-2 h-4 w-4 animate-spin" />
                        )}
                        Entrar
                    </Button>
                </div>
            </form>
        </div>
    )
}