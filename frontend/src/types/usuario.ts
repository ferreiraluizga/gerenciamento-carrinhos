export interface UsuarioRequest {
    nome: string;
    email: string;
    senha: string;
}

export interface UsuarioResponse {
    nome: string;
    email: string;
    senha: string;
    role: string;
}