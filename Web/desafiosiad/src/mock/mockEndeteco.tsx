import { Endereco } from "@/model/endereco";
import { mockFisico } from "./mockFisico";

export const mockEndereco: Endereco = {
    id: '1',
    cep: '12345-678',
    bairro: 'Centro',
    rua: 'Rua das Flores',
    numero: 123,
    fisico: mockFisico,
  };