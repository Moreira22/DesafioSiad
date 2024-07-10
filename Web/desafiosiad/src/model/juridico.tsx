import { Pessoa } from "./pessoa";
import { Produto} from "./produto";

export interface Juridico extends Pessoa{
    cnpj: string;
    produto?: Produto;
}
