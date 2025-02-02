import { Contato } from "../contato.model";
import { Endereco } from "../endereco.model";

export class Empresa {
    id?: number;
    cnpj?: string;
    razaoSocial?: string;
    fantasia?: string;
    porte?: string;
    quantidadeFuncionarios?: number;
    endereco?: Endereco;
    contato?: Contato;
}