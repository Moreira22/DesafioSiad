import { Fisico } from "./fisico";

export interface Venda{
    id:string;
    total:number;
    quatidade:string;
    fisico?: Fisico;
}