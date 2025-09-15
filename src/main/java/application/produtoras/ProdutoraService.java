package application.produtoras;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProdutoraService {
    @Autowired
    ProdutoraRepository produtoraRepo;

    public Iterable<ProdutoraDTO> getAll() {
        return produtoraRepo.findAll().stream().map(ProdutoraDTO::new).toList();
    }

    public ProdutoraDTO getById(long id){
        Optional <Produtora> produtora = produtoraRepo.findById(id);

        if (produtora.isEmpty()) {
                throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Artista não encontrado."
                );
        }
        return new ProdutoraDTO(produtora.get());
    }

    public ProdutoraDTO insert(ProdutoraInsertDTO dados){
        return new ProdutoraDTO(produtoraRepo.save(new Produtora(dados)));
    }
}
