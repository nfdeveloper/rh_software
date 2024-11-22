import { Contato } from "../contato.model";
import { Empresa } from "../empresa/empresa.model";
import { Endereco } from "../endereco.model";
import { Funcao } from "../funcao/funcao.model";
import { Setor } from "../setor/setor.model";

export class Funcionario {
    id?: number;
    nomeCompleto?: string;
    sobrenome?: string;
    cpf?: string;
    dataNascimento?: Date;
    dataAdmissao?: Date;
    dataDesligamento?: Date;
    sexoNascimento?: string;
    peso?: number;
    altura?: number;
    imc?: number;
    imcDescricao?: string;
    pcd?: boolean;
    possuiFilhos?: boolean;
    endereco?: Endereco;
    contrato?: Contato;
    status?: string;
    empresa?: Empresa;
    setor?: Setor;
    funcao?: Funcao;
}