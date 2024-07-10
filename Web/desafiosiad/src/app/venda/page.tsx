import { Button } from "@/components/ui/button";
import { ScrollArea } from "@/components/ui/scroll-area";
import Image from "next/image";
import Link from "next/link";
import { DataTableVendas } from "./components/tabelaListVendas";

export default function Venda() {
  return (
    <ScrollArea className="h-[89vh] w-full p-14 bg-[#FFFFF]">
      <div className="flex-col gap-96 p-5">
        <h1 className=" text-2xl text-[#00000] font-semibold ">Lista de Vendas</h1>
        <div className="py-16">
          <DataTableVendas />
        </div>
      </div>
    </ScrollArea>
  );
}
