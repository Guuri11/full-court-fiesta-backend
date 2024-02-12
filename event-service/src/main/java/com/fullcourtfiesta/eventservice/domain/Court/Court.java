package com.fullcourtfiesta.eventservice.domain.Court;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("court")
public class Court {

  @Id
  private Long id;
  private String name;
  private String direction;
  private String latitude;
  private String longitude;
  @Column("created_at")
  private LocalDateTime createdAt;
  @Column("updated_at")
  private LocalDateTime updatedAt;

}