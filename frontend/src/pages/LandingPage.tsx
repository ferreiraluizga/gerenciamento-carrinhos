import { Link } from 'react-router-dom';

export default function LandingPage() {
    return (
        <div className="bg-light text-dark min-h-screen d-flex flex-column font-sans">
            <header className="navbar navbar-expand-lg navbar-white bg-white border-bottom sticky-top shadow-sm py-3">
                <div className="container">
                    <Link to="/" className="navbar-brand d-flex align-items-center gap-2 fw-bold text-primary fs-4">
                        <i className="bi bi-cart4 text-primary fs-3"></i>
                        <div>
                            <span className="text-dark">Gerenciador de </span>
                            <span className="text-primary">Carrinhos</span>
                        </div>
                    </Link>

                    <div className="d-flex align-items-center gap-3">
                        <span className="text-muted d-none d-md-inline small border-end pe-3">E.E. Comendador Mario Reys</span>
                        <Link to="/login" className="btn btn-outline-primary px-4 fw-semibold shadow-sm">
                            <i className="bi bi-box-arrow-in-right me-2"></i>Acessar Sistema
                        </Link>
                    </div>
                </div>
            </header>

            {/* 2. HERO SECTION (Z-PATTERN UX) */}
            <main className="flex-grow-1">
                {/* 2. HERO SECTION */}
                <section className="bg-white py-5 border-bottom">
                    <div className="container py-5">
                        <div className="row align-items-center g-5">
                            <div className="col-lg-6 text-center text-lg-start">
                <span className="badge bg-success-subtle text-success border border-success-subtle rounded-pill px-3 py-2 mb-3 fw-semibold">
                  <i className="bi bi-check-circle-fill me-2"></i>Arquitetura Limpa & Segura
                </span>
                                <h1 className="display-5 fw-black text-dark tracking-tight mb-4 lh-sm">
                                    Otimize o fluxo de agendamento de dispositivos na sua escola
                                </h1>
                                <p className="lead text-secondary mb-5">
                                    Uma API robusta desenhada para melhorar a gestão de plataformas de carregamento móvel, reservas de equipamentos por professores e o controle total de ativos.
                                </p>
                                <div className="d-flex flex-column flex-sm-row gap-3 justify-content-center justify-content-lg-start">
                                    <Link to="/login" className="btn btn-primary btn-lg px-5 py-3 fw-bold shadow">
                                        Fazer Login no Sistema
                                    </Link>
                                    <a href="#funcionalidades" className="btn btn-light btn-lg px-5 py-3 fw-semibold border">
                                        Ver Funcionalidades
                                    </a>
                                </div>
                            </div>

                            {/* Mockup Interativo simulando dados da Escola */}
                            <div className="col-lg-6">
                                <div className="bg-light p-4 rounded-4 shadow-sm border position-relative overflow-hidden">
                                    <div className="p-3 bg-white rounded-3 shadow-sm border-start border-primary border-4 mb-3">
                                        <div className="d-flex justify-content-between align-items-center mb-1">
                                            <h6 className="fw-bold mb-0 text-dark">Carrinho de Notebooks #01</h6>
                                            <span className="badge bg-success">Disponível</span>
                                        </div>
                                        <small className="text-muted"><i className="bi bi-layers me-1"></i> 20 Dispositivos Chrome</small>
                                    </div>

                                    <div className="p-3 bg-white rounded-3 shadow-sm border-start border-warning border-4 mb-3">
                                        <div className="d-flex justify-content-between align-items-center mb-1">
                                            <h6 className="fw-bold mb-0 text-dark">Plataforma de Carga Tablets #03</h6>
                                            <span className="badge bg-warning text-dark">Reservado - 3º Ano A</span>
                                        </div>
                                        <small className="text-muted"><i className="bi bi-person me-1"></i> Prof. Roberto Silva (14h00)</small>
                                    </div>

                                    <div className="p-3 bg-white rounded-3 shadow-sm border-start border-danger border-4">
                                        <div className="d-flex justify-content-between align-items-center mb-1">
                                            <h6 className="fw-bold mb-0 text-dark">Carrinho Chromebooks #02</h6>
                                            <span className="badge bg-danger">Ocorrência Ativa</span>
                                        </div>
                                        <small className="text-muted"><i className="bi bi-tools me-1"></i> Aguardando manutenção de tela</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                {/* 3. PRINCIPAIS FUNCIONALIDADES */}
                <section id="funcionalidades" className="py-5 bg-light">
                    <div className="container py-5">
                        <div className="text-center max-w-3xl mx-auto mb-5">
                            <h2 className="fw-bold text-dark display-6 mb-3">✨ Funcionalidades do Sistema</h2>
                            <p className="text-secondary lead">Estrutura inteligente projetada para eliminar conflitos de horários na secretaria.</p>
                        </div>

                        <div className="row g-4 mt-2">
                            {/* Funcionalidade 1 */}
                            <div className="col-md-4">
                                <div className="card h-100 p-4 border-0 shadow-sm rounded-4">
                                    <div className="bg-primary-subtle text-primary rounded-4 d-flex align-items-center justify-content-center mb-4" style={{ width: '56px', height: '56px' }}>
                                        <i className="bi bi-laptop fs-3"></i>
                                    </div>
                                    <h4 className="fw-bold text-dark mb-3">Plataformas e Dispositivos</h4>
                                    <p className="text-secondary sm:text-sm leading-relaxed mb-0">
                                        Cadastro, vinculação e rastreamento completo de plataformas de carregamento móvel (carrinhos) e dos aparelhos eletrônicos alocados em cada setor.
                                    </p>
                                </div>
                            </div>

                            {/* Funcionalidade 2 */}
                            <div className="col-md-4">
                                <div className="card h-100 p-4 border-0 shadow-sm rounded-4">
                                    <div className="bg-info-subtle text-info rounded-4 d-flex align-items-center justify-content-center mb-4" style={{ width: '56px', height: '56px' }}>
                                        <i className="bi bi-calendar-check fs-3"></i>
                                    </div>
                                    <h4 className="fw-bold text-dark mb-3">Controle de Agendamentos</h4>
                                    <p className="text-secondary sm:text-sm leading-relaxed mb-0">
                                        Reserva de carrinhos por professores com atualização em tempo real da disponibilidade, mitigando atritos de reservas duplicadas no mesmo período.
                                    </p>
                                </div>
                            </div>

                            {/* Funcionalidade 3 */}
                            <div className="col-md-4">
                                <div className="card h-100 p-4 border-0 shadow-sm rounded-4">
                                    <div className="bg-danger-subtle text-danger rounded-4 d-flex align-items-center justify-content-center mb-4" style={{ width: '56px', height: '56px' }}>
                                        <i className="bi bi-exclamation-octagon fs-3"></i>
                                    </div>
                                    <h4 className="fw-bold text-dark mb-3">Controle de Ocorrências</h4>
                                    <p className="text-secondary sm:text-sm leading-relaxed mb-0">
                                        Registro detalhado de incidentes com os equipamentos (como avarias ou perdas), garantindo um histórico preciso de conservação dos ativos.
                                    </p>
                                </div>
                            </div>

                            {/* Funcionalidade 4 (Abaixo) */}
                            <div className="col-md-6 mt-4">
                                <div className="card h-100 p-4 border-0 shadow-sm rounded-4">
                                    <div className="d-flex align-items-start gap-4">
                                        <div className="bg-success-subtle text-success rounded-4 d-flex align-items-center justify-content-center flex-shrink-0" style={{ width: '56px', height: '56px' }}>
                                            <i className="bi bi-shield-lock-fill fs-3"></i>
                                        </div>
                                        <div>
                                            <h4 className="fw-bold text-dark mb-2">Segurança & Níveis de Acesso</h4>
                                            <p className="text-secondary sm:text-sm leading-relaxed mb-0">
                                                Controle rigoroso por perfis (secretaria/administradores e professores) usando tokens JWT protegidos pela camada do Spring Security do seu backend.
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            {/* Funcionalidade 5 (Abaixo) */}
                            <div className="col-md-6 mt-4">
                                <div className="card h-100 p-4 border-0 shadow-sm rounded-4">
                                    <div className="d-flex align-items-start gap-4">
                                        <div className="bg-warning-subtle text-warning-emphasis rounded-4 d-flex align-items-center justify-content-center flex-shrink-0" style={{ width: '56px', height: '56px' }}>
                                            <i className="bi bi-code-square fs-3"></i>
                                        </div>
                                        <div>
                                            <h4 className="fw-bold text-dark mb-2">Documentação Interativa</h4>
                                            <p className="text-secondary sm:text-sm leading-relaxed mb-0">
                                                Totalmente mapeada via Swagger/OpenAPI. Permite que desenvolvedores façam testes rápidos e simulações de payloads diretamente pelo navegador.
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </section>
            </main>

            {/* 4. FOOTER INSTITUCIONAL */}
            <footer className="bg-dark text-white-50 py-5 border-top border-secondary">
                <div className="container">
                    <div className="row align-items-center justify-content-between g-3">
                        <div className="col-sm-6 text-center text-sm-start">
                            <span className="small">&copy; {new Date().getFullYear()} SmartInventory. Todos os direitos reservados.</span>
                        </div>
                        <div className="col-sm-6 text-center text-sm-end d-flex justify-content-center justify-content-sm-end gap-4 small">
                            <a href="#" className="text-white-50 text-decoration-none hover-white">Políticas de Privacidade</a>
                            <a href="#" className="text-white-50 text-decoration-none hover-white">Termos de Uso</a>
                        </div>
                    </div>
                </div>
            </footer>

        </div>
    );
}