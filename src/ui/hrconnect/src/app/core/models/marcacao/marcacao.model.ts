import { Funcionario } from "../funcionario/funcionario.model";

export class Marcacao {
    id?: number;
    localizacao?: string;
    dataMarcacao?: Date;
    status?: string;
    funcionario?: Funcionario;
}