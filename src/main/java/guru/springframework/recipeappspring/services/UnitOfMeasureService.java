package guru.springframework.recipeappspring.services;

import guru.springframework.recipeappspring.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
