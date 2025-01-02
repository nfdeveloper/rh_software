import { Contato } from "../contato.model";
import { Endereco } from "../endereco.model";

export class EmpresaCreate{
    id?: number;
    cnpj?: string;
    razaoSocial?: string;
    fantasia?: string;
    porte?: string;
    quantidadeFuncionarios?: number;
    endereco: Endereco = new Endereco();
    contato: Contato = new Contato();
}