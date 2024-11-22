import { Contato } from "../contato.model";
import { Endereco } from "../endereco.model";

export class EmpresaCreate{
    id?: number;
    cnpj?: string;
    razaoSocial?: string;
    fantasia?: string;
    porte?: string;
    endereco?: Endereco;
    contato?: Contato;
}