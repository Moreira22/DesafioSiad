"use client";

import { Button } from "@/components/ui/button";

import {
  Bolt,
  Cloud,
  MessageCircle,
  PlusCircle,
  User,
  Users,
} from "lucide-react";
import Link from "next/link";
import { usePathname } from "next/navigation";
import { Separator } from "./separator";

const Sidebar = () => {
  const path = usePathname();
  return (
    <div className="flex bg-primary text-white w-[300px] h-[calc(112vh_-_75px)] flex-col items-center gap-10 border-r border-solid border-accent">
      <div className="flex w-full flex-col p-5">
        <div className="flex justify-center">
        </div>
        <Link href={"/empresa"}>
          <Button
            variant="ghost"
            className={`flex w-full justify-start gap-2
          ${
            path?.includes("/empresa") &&
            "bg-primary text-white hover:bg-primary"
          }
        `}
          >
            <User size={16} />
            Empresa
          </Button>
        </Link>
        <Separator className="w-[250px]" />
        <Link href="/vededor">
          <Button
            variant="ghost"
            className={`flex w-full justify-start gap-2 ${
              path?.includes("/vededor") &&
              "bg-primary text-white hover:bg-primary"
            }`}
          >
            <Users size={16} />
            Vededor
          </Button>
        </Link>
        <Separator className="w-[250px]" />
        <Link href="/produto">
          <Button
            variant="ghost"
            className={`flex w-full justify-start gap-2 ${
              path?.includes("/produto") &&
              "bg-primary text-white hover:bg-primary"
            }`}
          >
            <Cloud size={16} />
            Produto
          </Button>
        </Link>
        <div className="flex justify-center">
          <Separator className="w-[250px]" />
        </div>
        <Link href="/venda">
          <Button
            variant="ghost"
            className={`flex w-full justify-start gap-2 ${
              path?.includes("/venda") &&
              "bg-primary text-white hover:bg-primary"
            }`}
          >
            <Bolt size={16} />
            venda
          </Button>
        </Link>
      </div>
    </div>
  );
};

export default Sidebar;
