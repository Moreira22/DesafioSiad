import { Pessoa } from "./pessoa";
import { Produto} from "./produto";

export interface juridico extends Pessoa{
    cnpj: string;
    produto: Produto;
}