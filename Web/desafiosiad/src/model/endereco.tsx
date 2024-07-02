import { Fisico } from "./fisico";

export interface Endereco{
    id: string;
    cep: string;
    bairro: string;
    rua: string;
    numero: number;
    fisico: Fisico
}