package model;

import java.util.ArrayList;

/**
* Classe que representa um inventário.
*/
public class Inventario {
    private String nomeProprietario;
    private boolean proprietarioPessoaFisica;
    private ArrayList<Item> itens;

    /**
    * Constrói um objeto Inventario com os parâmetros especificados.
    *
    * @param nomeProprietario         o nome do proprietário do inventário
    * @param proprietarioPessoaFisica um indicador se o proprietário é uma pessoa
    *                                 física (true) ou não (false)
    * @param itens                    a lista de itens do inventário
    */
    public Inventario(
            String nomeProprietario,
            boolean proprietarioPessoaFisica,
            ArrayList<Item> itens) {
        this.nomeProprietario = nomeProprietario;
        this.proprietarioPessoaFisica = proprietarioPessoaFisica;
        this.itens = new ArrayList<>(); // Inicializa a lista de itens vazia
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public boolean isProprietarioPessoaFisica() {
        return proprietarioPessoaFisica;
    }

    public void setProprietarioPessoaFisica(boolean proprietarioPessoaFisica) {
        this.proprietarioPessoaFisica = proprietarioPessoaFisica;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public ArrayList<String> getMoveis() {
        ArrayList<String> moveis = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Movel) {
                moveis.add(item.getNome());
            }
        }
        return moveis;
    }

    public ArrayList<String> getImoveis() {
        ArrayList<String> imoveis = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Imovel) {
                imoveis.add(item.getNome());
            }
        }
        return imoveis;
    }

    public ArrayList<String> getVeiculos() {
        ArrayList<String> veiculos = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Veiculo) {
                veiculos.add(item.getNome());
            }
        }
        return veiculos;
    }

    @Override
    public String toString() {
        String result;
        result = getNomeProprietario();
        for (Item item : itens) {
            result += item.getNome();
        }
        return result;
    }

    /**
    * Pesquisa um item no inventário pelo nome.
    *
    * @param nome o nome do item a ser pesquisado
    * @return o item encontrado ou null se não encontrado
    */
    public Item pesquisarItem(String nome) {
        for (Item item : itens) {
            if (item.getNome().contains(nome)) {
                return item;
            }
        }
        return null;
    }

    /**
    * Exclui um item do inventário pelo nome.
    *
    * @param nome o nome do item a ser excluído
    */
    public void excluirItem(String nome) {
        itens.remove(pesquisarItem(nome));
    }

    /**
    * Adiciona um item à lista de itens do inventário.
    *
    * @param item o item a ser adicionado
    */
    public void addItem(Item item) {
        itens.add(item);
    }

    /**
     * Edita um item no inventário pelo nome.
     *
     * @param nome        o nome do item a ser editado
     * @param itemEditado o item editado
     */
    public void editarItem(String nome, Item itemEditado) {
        int index = -1; // Inicialize o índice com um valor inválido
        int i = 0;
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                index = i;
                break; // Se encontrou o item, sai do loop
            }
            i++;
        }
        if (index != -1) {
            itens.set(index, itemEditado);
        }
    }

    /**
     * Adiciona dados predefinidos de itens ao inventário.
     */
    public void dadosPrecarregados() {
        Veiculo transporte;
        transporte = new Veiculo(
                "corvette",
                "carro",
                250000,
                "amarelo com rodas aro 20",
                "brasilia",
                "27/07/2022",
                "pkq2131",
                "p");

        itens.add(transporte);
        Imovel moradia;
        moradia = new Imovel(
                "casa de praia",
                "casa",
                1000000,
                "casa laranja na praia",
                "maceio",
                "27/03/2009",
                7,
                230);

        itens.add(moradia);
        Movel mobilia;
        mobilia = new Movel(
                "TV",
                "eletronico",
                15000,
                "90 polegadas branca",
                "casa de praia",
                "15/07/2020",
                "90");

        itens.add(mobilia);

    }
}