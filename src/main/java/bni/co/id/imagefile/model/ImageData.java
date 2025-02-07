package bni.co.id.imagefile.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ImageData {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String type;
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;

}
