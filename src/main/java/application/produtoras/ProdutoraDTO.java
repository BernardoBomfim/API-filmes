package application.produtoras;

public record ProdutoraDTO (long id, String nome) {
    public ProdutoraDTO (Produtora produtora){
        this(produtora.getId(), produtora.getNome());
    }
}
