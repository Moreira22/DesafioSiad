import { Button } from "@/components/ui/button";
import { ScrollArea } from "@/components/ui/scroll-area";
import Image from "next/image";
import Link from "next/link";
import { DataTableProduto } from "./components/tabelaListProduto";

export default function Produto() {
  return (
    <ScrollArea className="h-[89vh] w-full p-14 bg-[#FFFFF]">
      <div className="flex-col gap-96 p-5">
        <h1 className=" text-2xl text-[#00000] font-semibold ">Lista de Produtos</h1>
        <div>
          <Link href={"/produto/cadastro"}>
            <Button
              className="  bg-primary flex float-end border  border-[#A7A7A7] h-10 w-50% rounded-full px-6 py-2 text-sm ring-offset-background file:border-0 fi
                        le:bg-transparent file:text-sm file:font-medium  focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 
                        disabled:cursor-not-allowed disabled:opacity-50 gap-3"
            >
              CADASTRA PRODUTO
            </Button>
          </Link>
        </div>
        <div className="py-16">
          <DataTableProduto/>
        </div>
      </div>
    </ScrollArea>
  );
}
