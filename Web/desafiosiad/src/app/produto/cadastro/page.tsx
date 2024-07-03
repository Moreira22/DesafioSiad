import { ScrollArea } from "@/components/ui/scroll-area";
import { FormProduto } from "../components/form";

export default function CadastraEmpresa() {
  return (
    <ScrollArea className="h-[89vh] w-full p-10 bg-[#FFFFF]">
      <div className="flex gap-12">
        <h1 className=" text-2xl text-[#00000] font-semibold">Produto</h1>
      </div>
      <div className="py-9">
        <FormProduto />
      </div>
    </ScrollArea>
  );
}
