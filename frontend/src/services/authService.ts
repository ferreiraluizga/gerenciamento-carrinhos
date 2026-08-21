import { api } from "../api/api"
import type { LoginResponse, LoginRequest } from "../types/auth"

export const authService = {

    async login(dados: LoginRequest): Promise<LoginResponse> {
        const response =  await api.post<LoginResponse>("/auth/login", dados);

        if (response.data && response.data.token) {
            localStorage.setItem("token", response.data.token);
        }

        return response.data;
    },

    logout() {
        localStorage.removeItem("token");
    },

    getToken() {
        return localStorage.getItem("token");
    },

    isAuthenticated() {
        return !!localStorage.getItem("token");
    }

}