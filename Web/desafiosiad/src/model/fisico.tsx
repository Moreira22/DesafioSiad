import { Pessoa } from "./pessoa";
import { Endereco } from "./endereco";
import { Venda} from "./venda";

export interface Fisico extends Pessoa{
    cpf: string;
    endereco?: Endereco;
    venda?: Venda;
}