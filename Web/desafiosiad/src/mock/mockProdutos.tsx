import {Produto} from "@/model/produto";
import {mockJuridico} from "./mockJuritico"
export const mockProdutos : Produto[] = [
    {
      id: "1",
      nome: "Echo Dot de 5ª geração",
      valor: 349.99,
      juridico: mockJuridico,
    },
    {
      id: "2",
      nome: "Smart Lâmpada Wi-Fi Positivo",
      valor: 79.99,
      juridico: mockJuridico,
    },
    {
      id: "3",
      nome: "JBL Tune 720BT",
      valor: 299.99,
      juridico: mockJuridico,
    },
  ];