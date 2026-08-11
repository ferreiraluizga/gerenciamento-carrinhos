-- 1. POPULAR TURMAS
INSERT INTO turmas (nome, turno) VALUES ('1º Ano A', 'MATUTINO');
INSERT INTO turmas (nome, turno) VALUES ('2º Ano B', 'MATUTINO');
INSERT INTO turmas (nome, turno) VALUES ('3º Ano C', 'NOTURNO');

-- 2. POPULAR CARRINHOS
INSERT INTO carrinhos (descricao) VALUES ('Carrinho de Notebooks - Bloco A');
INSERT INTO carrinhos (descricao) VALUES ('Carrinho de Tablets - Bloco B');
INSERT INTO carrinhos (descricao) VALUES ('Carrinho de Chromebooks - Biblioteca');

-- 3. POPULAR DISPOSITIVOS
-- Vinculado ao Carrinho 1 (Notebooks)
INSERT INTO dispositivos (serial, num_dispositivo, modelo_dispositivo, sistema_operacional, ativo, manutencao, observacao, carrinho_id)
VALUES ('SN-NOTE-001', 1, 'POSITIVON8440', 'WINDOWS10', true, false, 'Funcionando perfeitamente', 1);

INSERT INTO dispositivos (serial, num_dispositivo, modelo_dispositivo, sistema_operacional, ativo, manutencao, observacao, carrinho_id)
VALUES ('SN-NOTE-002', 2, 'POSITIVON1110', 'WINDOWS11', true, false, 'Teclado trocado recentemente', 1);

-- Vinculado ao Carrinho 2 (Tablets)
INSERT INTO dispositivos (serial, num_dispositivo, modelo_dispositivo, sistema_operacional, ativo, manutencao, observacao, carrinho_id)
VALUES ('SN-TAB-001', 1, 'TABLETPOSITIVO', 'ANDROID', true, false, 'Tela com pequenos riscos', 2);

-- Vinculado ao Carrinho 3 (Chromebooks)
INSERT INTO dispositivos (serial, num_dispositivo, modelo_dispositivo, sistema_operacional, ativo, manutencao, observacao, carrinho_id)
VALUES ('SN-CHRO-001', 1, 'CHROMEBOOK', 'CHROMEOS', false, true, 'Enviado para assistência - Não liga', 3);
