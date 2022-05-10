package dat.startcode.model.persistence;

import dat.startcode.model.entities.Parts;
import dat.startcode.model.exceptions.DatabaseException;

import java.util.ArrayList;

public interface IPartsMapper {
    ArrayList<Parts> getParts() throws DatabaseException;
}
