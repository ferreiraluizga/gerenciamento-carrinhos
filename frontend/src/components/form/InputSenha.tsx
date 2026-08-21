import { useState, ChangeEvent } from "react";

interface InputSenhaProps {
    margin?: string;
    value: string;
    onChange: (e: ChangeEvent<HTMLInputElement>) => void;
}

export default function InputSenha({ margin = "", value, onChange }: InputSenhaProps) {
    const [visibilidadeSenha, setVisibilidadeSenha] = useState(false);

    const alterarVisibilidadeSenha = () => {
        setVisibilidadeSenha(antigoValor => !antigoValor);
    };

    return (
        <div className={margin}>
            {/* Padronizado com as mesmas classes de estilo do seu outro input */}
            <label className="mb-1 form-label fw-medium text-secondary">Senha</label>
            <div className="input-group mb-3">
                <input
                    type={visibilidadeSenha ? "text" : "password"}
                    className="form-control border-1 shadow-sm input-custom-focus"
                    value={value}
                    onChange={onChange}
                    required
                />
                <button
                    type="button"
                    className="btn btn-outline-warning"
                    onClick={alterarVisibilidadeSenha}
                >
                    <i className={`bi ${visibilidadeSenha ? "bi-eye-slash" : "bi-eye"}`}></i>
                </button>
            </div>
        </div>
    );
}
