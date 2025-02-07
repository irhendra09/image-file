package bni.co.id.imagefile.repository;

import bni.co.id.imagefile.model.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageData, String> {
    Optional<ImageData> findByName(String fileName);
}
