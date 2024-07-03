import { Juridico } from "./juridico";

export interface Produto{
    id: string;
    nome: string;
    valor: number;
    juridico: Juridico
}