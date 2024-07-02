import { juridico } from "./juridico";

export interface Produto{
    id: string;
    nome: string;
    valor: number;
    juridico: juridico
}