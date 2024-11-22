import { Contato } from "../contato.model";
import { Endereco } from "../endereco.model";

export class FuncionarioCreate {
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
    setorId?: number;
    funcaoId?: number;
}