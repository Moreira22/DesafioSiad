import { Fisico } from "@/model/fisico";
import { mockEndereco } from "./mockEndeteco";

export const mockFisico: Fisico = {
    id: "1",
    nome: 'João da Silva',
    dataNascimento: "09/05/1970",
    cpf: '123.456.789-00',
    endereco: mockEndereco,
  };