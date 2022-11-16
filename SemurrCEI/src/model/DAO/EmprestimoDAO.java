package model.DAO;

import java.sql.Connection;
import model.Emprestimo;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import model.Equipamento;
import model.Nome;
import model.TipoEquipamento;
import model.Unidade;

public class EmprestimoDAO
{
    
    private final Connection conexao;
    
    //metodo construtor
    public EmprestimoDAO(Connection conexao)
    {
        
        this.conexao = conexao;
        
    }   

    //função para inserir(insert) 
    public void inserir(Emprestimo emprestimo, Equipamento equip) throws SQLException
    { 
        
        String sql = "insert into emprestimo(unidade,tipoequip,modelo,destino,nome,dataSaida,dataDevolucao,status,tipo,observacao,tombo,serie)values (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        String sql2 = "update equipamento set status = 'INDISPONIVEL' where id = ?";      
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
        PreparedStatement pstm2 = conexao.prepareStatement(sql2);
        
        try
        {
            
            //antes de executar pstm setString
            pstm.setInt(1, emprestimo.getUnidade().getId());
            pstm.setInt(2, emprestimo.getTipoequip().getId());
            pstm.setString(3, emprestimo.getModelo());
            pstm.setInt(4, emprestimo.getDestino().getId());
            pstm.setInt(5, emprestimo.getNome().getId());
            pstm.setDate(6, new java.sql.Date(emprestimo.getDataSaida().getTime()));
            pstm.setDate(7, new java.sql.Date(emprestimo.getDataDevolucao().getTime()));
            pstm.setString(8, emprestimo.getStatus());
            pstm.setString(9, emprestimo.getTipo());
            pstm.setString(10, emprestimo.getObservacao());
            pstm.setString(11, emprestimo.getTombo());
            pstm.setString(12, emprestimo.getSerie());
            
            try
            {
                
                //antes de executar pstm setString 
                pstm2.setInt(1, equip.getId());               
            
                pstm2.execute();                 
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao atualizar equipamento antes de inserir emprestimo:"+ex);
                
            }
            finally
            {
                
                //feche a conexao e o pstm     
                pstm2.close();
                
            }    
        
            //execute o pstm
            pstm.execute();      
            
        }    
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao inserir emprestimo no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE); 
            
        }
        finally
        {
            
            //feche a conexao e o pstm    
            conexao.close();  
            pstm.close();    
            
        }   
        
    } 
    
    //função para atualizar(update)
    public void atualizar(Emprestimo emprestimo) throws SQLException
    {
        
        String sql = "update emprestimo set unidade = ?, tipoequip = ?, destino = ?, nome = ?, dataSaida = ?,"
        + "dataDevolucao = ?, status = ?, tipo = ?, observacao = ?, tombo = ?, serie = ? where id = ?";
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);
        
            try
            {
                
            //antes de executar pstm setString
            pstm.setInt(1, emprestimo.getUnidade().getId());
            pstm.setInt(2, emprestimo.getTipoequip().getId());
            pstm.setString(3, emprestimo.getModelo());
            pstm.setInt(4, emprestimo.getDestino().getId());
            pstm.setInt(5, emprestimo.getNome().getId());
            pstm.setDate(6, new java.sql.Date(emprestimo.getDataSaida().getTime()));
            pstm.setDate(7, new java.sql.Date(emprestimo.getDataDevolucao().getTime()));
            pstm.setString(8, emprestimo.getStatus());
            pstm.setString(9, emprestimo.getTipo());
            pstm.setString(10, emprestimo.getObservacao());
            pstm.setString(11, emprestimo.getTombo());
            pstm.setString(12, emprestimo.getSerie());
                
                pstm.execute();
                
            }
            catch (SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao atualizar emprestimo no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
                
            }
            finally
            {
                
                //feche a conexao e o pstm 
                conexao.close();
                pstm.close();                 
                
            }               
        
    }    
    
    public void devolverEmprestimo(Emprestimo empre, Equipamento equip) throws SQLException
    {
        
        String sql = "update emprestimo set status = 'DISPONIVEL' where id = ?";
        
        String sql2 = "update equipamento set status = 'DISPONIVEL' where id = ?";  
        
        //criamos um statement para executar a query sql
        PreparedStatement pstm = conexao.prepareStatement(sql);

        //criamos um statement para executar a query sql
        PreparedStatement pstm2 = conexao.prepareStatement(sql2);  
        
        try
        {
            
            //antes de executar pstm setString
            pstm.setInt(1, empre.getId());
            
            try
            {
                
                pstm2.setInt(1, equip.getId());
                
                pstm2.execute();                  
                
            }
            catch(SQLException ex)
            {
                
                JOptionPane.showMessageDialog(null, "Error ao atualizar equipamento antes de devolver emprestimo:"+ex);
                
            }
            finally
            {
                
                pstm2.close();
                
            }    
            
            //execute o pstm
            pstm.execute();   
            
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, "Error ao devolver emprestimo no banco de dados!" + ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally
        {
            
            //feche a conexao e o pstm    
            conexao.close();  
            pstm.close();  
            
        }    
    
    }    
    
    //metodo para trazer todos emprestimos do banco de dados
    public ArrayList<Emprestimo> selecioneAllEmprestimos() throws SQLException
    {
        
        String sql ="select * from emprestimo as e inner join unidade u on e.unidade = u.id inner join nome as n on e.nome = n.id inner join tipoequipamento as tipoequi on e.tipoequip = tipoequi.id inner join unidade udestino on e.destino = udestino.id";
        
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
     
        try
        {
         
            PreparedStatement pstm = conexao.prepareStatement(sql);
         
            ResultSet rs = pstm.executeQuery();
         
            while(rs.next())
            {
            
            Emprestimo emprestimo = new Emprestimo();
            //Laço de repetição para preencher com os dados do banco o objeto emprestimo;
            emprestimo.setId(rs.getInt("id"));
                
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            emprestimo.setUnidade(unidade1); 
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            emprestimo.setTipoequip(tipoequipamento);
            
            emprestimo.setModelo(rs.getString("modelo"));
            
            Unidade destino = new Unidade();
            destino.setId(rs.getInt("id"));
            destino.setUnidadenome(rs.getString("unidadenome"));
            
            emprestimo.setDestino(destino);
            
            Nome nome = new Nome();
            nome.setId(rs.getInt("id"));
            nome.setNomepessoa(rs.getString("nomepessoa"));
            
            emprestimo.setNome(nome);
            
            emprestimo.setDataSaida(rs.getDate("dataSaida"));
            
            emprestimo.setDataDevolucao(rs.getDate("dataDevolucao"));
            
            emprestimo.setStatus(rs.getString("status"));
            
            emprestimo.setTipo(rs.getString("tipo"));
            
            emprestimo.setObservacao(rs.getString("observacao"));
            
            emprestimo.setTombo(rs.getString("tombo"));
            
            emprestimo.setSerie(rs.getString("serie"));
            
            emprestimos.add(emprestimo);   
             
            }    
         
        }
        catch(SQLException ex)
        {
         
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos emprestimos do banco de dados!" +ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
         
        }
        finally
        {//feche a conexao
            conexao.close();    
        }       
  
        //retorne o array emprestimos
    return emprestimos;             
        
    }        

    //metodo para selecionar equipamento emprestimo
    public boolean selecionaEquipEmprestimo(String equipamentoU) throws SQLException {
        ArrayList emprestimos = new ArrayList();
        //Faz a instância da classe equipamento 
        String sql = "select * from emprestimo as e inner join unidade u on e.unidade = u.id inner join nome as n on e.nome = n.id inner join tipoequipamento as tipoequi on e.tipoequip = tipoequi.id inner join unidade udestino on e.destino = udestino.id where e.modelo = ? and e.status = 'EMPRESTADO'";
        //Instrução SQL para seleção de registro específico da tabela equipamento;
        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);

            pstm.setString(1, equipamentoU);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
            Emprestimo emprestimo = new Emprestimo();
            //Laço de repetição para preencher com os dados do banco o objeto emprestimo;
            emprestimo.setId(rs.getInt("id"));
                
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            emprestimo.setUnidade(unidade1); 
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            emprestimo.setTipoequip(tipoequipamento);
            
            emprestimo.setModelo(rs.getString("modelo"));
            
            String model = rs.getString("modelo");
            
            Unidade destino = new Unidade();
            destino.setId(rs.getInt("id"));
            destino.setUnidadenome(rs.getString("unidadenome"));
            
            emprestimo.setDestino(destino);
            
            Nome nome = new Nome();
            nome.setId(rs.getInt("id"));
            nome.setNomepessoa(rs.getString("nomepessoa"));
            
            emprestimo.setNome(nome);
            
            emprestimo.setDataSaida(rs.getDate("dataSaida"));
            
            emprestimo.setDataDevolucao(rs.getDate("dataDevolucao"));
            
            emprestimo.setStatus(rs.getString("status"));
            
            //variavel Stats recebe a coluna status do banco de dados
            String Stats = rs.getString("status");
            
            emprestimo.setTipo(rs.getString("tipo"));
            
            emprestimo.setObservacao(rs.getString("observacao"));
            
            emprestimo.setTombo(rs.getString("tombo"));
            
            emprestimo.setSerie(rs.getString("serie"));
            
            emprestimos.add(emprestimo);   

                //se modelo for igual ao valor da variavel equipamentoU ou Stats for igual a emprestado retorne true
                if (model.equalsIgnoreCase(equipamentoU) && Stats.equalsIgnoreCase("EMPRESTADO")) {

                    return true;

                } else {// se não retorne falso

                    return false;

                }

            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos emprestimos no banco de dados!" + ex, "Error!", JOptionPane.INFORMATION_MESSAGE);

        } finally {
            //feche a conexao
            conexao.close();

        }

        return false;
    }
    
    public Emprestimo selecioneEmprestimoModelo(String equipamentoU) throws SQLException
    {
        
        String sql ="select * from emprestimo as e inner join unidade u on e.unidade = u.id inner join nome as n on e.nome = n.id inner join tipoequipamento as tipoequi on e.tipoequip = tipoequi.id inner join unidade udestino on e.destino = udestino.id where e.modelo = ?";
        
        Emprestimo emprestimos = new Emprestimo();
     
        try
        {
         
            PreparedStatement pstm = conexao.prepareStatement(sql);
         
            pstm.setString(1, equipamentoU);
            
            ResultSet rs = pstm.executeQuery();
         
            while(rs.next())
            {
            
            Emprestimo emprestimo = new Emprestimo();
            //Laço de repetição para preencher com os dados do banco o objeto emprestimo;
            emprestimo.setId(rs.getInt("id"));
                
            Unidade unidade1 = new Unidade();
            unidade1.setId(rs.getInt("id"));
            unidade1.setUnidadenome(rs.getString("unidadenome"));
            
            emprestimo.setUnidade(unidade1); 
            
            TipoEquipamento tipoequipamento = new TipoEquipamento();
            tipoequipamento.setId(rs.getInt("id"));
            tipoequipamento.setTipoequipamento(rs.getString("tipoequipamentonome"));
            
            emprestimo.setTipoequip(tipoequipamento);
            
            emprestimo.setModelo(rs.getString("modelo"));
            
            Unidade destino = new Unidade();
            destino.setId(rs.getInt("id"));
            destino.setUnidadenome(rs.getString("unidadenome"));
            
            emprestimo.setDestino(destino);
            
            Nome nome = new Nome();
            nome.setId(rs.getInt("id"));
            nome.setNomepessoa(rs.getString("nomepessoa"));
            
            emprestimo.setNome(nome);
            
            emprestimo.setDataSaida(rs.getDate("dataSaida"));
            
            emprestimo.setDataDevolucao(rs.getDate("dataDevolucao"));
            
            emprestimo.setStatus(rs.getString("status"));
            
            emprestimo.setTipo(rs.getString("tipo"));
            
            emprestimo.setObservacao(rs.getString("observacao"));
            
            emprestimo.setTombo(rs.getString("tombo"));
            
            emprestimo.setSerie(rs.getString("serie"));
             
            }    
         
        }
        catch(SQLException ex)
        {
         
            JOptionPane.showMessageDialog(null, "Error ao pesquisar todos emprestimos por modelo do banco de dados!" +ex,"Error!", JOptionPane.INFORMATION_MESSAGE);
         
        }
        finally
        {//feche a conexao
            conexao.close();    
        }             
        
        return emprestimos;
        
    }        
}
