import { ScrollArea } from "@/components/ui/scroll-area";
import { FormVendedor } from "../components/form";

export default function CadastraVededor() {
  return (
    <ScrollArea className="h-[89vh] w-full p-10 bg-[#FFFFF]">
      <div className="flex gap-12">
        <h1 className=" text-2xl text-[#00000] font-semibold">Vendedor</h1>
      </div>
      <div>
        <FormVendedor />
      </div>
    </ScrollArea>
  );
}
