import { useState } from "react";
import {Juridico} from "@/model/juridico"
import Api from "@/server/server";

export const usejuridico = () => {

    const getJuridico = async (): Promise<Juridico | null> => {
        try {
            const response = await Api.get('/jurituco/ALL');
            return response.data;
        } catch (error) {
            console.error('Erro ao fazer login:', error);
            return null;
        }
    };
    const getJuridicoById = async (userId: string): Promise<Juridico | null> => {
        try {
            const response = await Api.get(`/jurituco${userId}`);
            return response.data;
        } catch (error) {
            console.error('Erro ao obter usuário:', error);
            return null;
        }
    };
    const PostJuridico = async (user: any): Promise<any | null> => {
        try {
            const response = await Api.post('/jurituco/register', user);
            return response.data;
        } catch (error) {
            console.error('Erro ao fazer login:', error);
            return null;
        }
    };

    return {  getJuridico, getJuridicoById, PostJuridico };
};