package guru.springframework.recipeappspring.services;

import guru.springframework.recipeappspring.domain.Recipe;
import guru.springframework.recipeappspring.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(id).get();
            Byte[] bytesObject = new Byte[file.getBytes().length];
            int i = 0;
            for (byte b: file.getBytes()) {
                bytesObject[i++] = b;
            }
            recipe.setImage(bytesObject);
            recipeRepository.save(recipe);
        } catch (Exception e){
            log.error("Error Occurred", e);
            e.printStackTrace();
        }
    }
}
