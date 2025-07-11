/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadetarefas;

import java.sql.*;

public class Cod {

    public static void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tarefas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                texto TEXT NOT NULL,
                concluido BOOLEAN NOT NULL,
                data_alteracao TEXT NOT NULL
            );
        """;

        try (Connection conn = Sql.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public static void adicionarTarefa(String texto) {
        String sql = "INSERT INTO tarefas(texto, concluido, data_alteracao) VALUES (?, false, datetime('now'))";

        try (Connection conn = Sql.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, texto);
            pstmt.executeUpdate();
            System.out.println("Tarefa adicionada!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }

    public static void alterarStatus(int id, boolean concluido) {
        String sql = "UPDATE tarefas SET concluido = ?, data_alteracao = datetime('now') WHERE id = ?";

        try (Connection conn = Sql.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, concluido);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Status atualizado!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar status: " + e.getMessage());
        }
    }

    public static void listarTarefas(String filtro) {
        String sql = "SELECT * FROM tarefas";

        switch (filtro) {
            case "pendentes" -> sql += " WHERE concluido = false";
            case "concluidas" -> sql += " WHERE concluido = true";
        }

        try (Connection conn = Sql.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("ID: %d | %s | %s | %s\n",
                    rs.getInt("id"),
                    rs.getString("texto"),
                    rs.getBoolean("concluido") ? "Concluida" : "Pendente",
                    rs.getString("data_alteracao")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
    }
}
