package com.example.lr1.entity

import org.hibernate.annotations.Immutable
import org.hibernate.annotations.Subselect
import org.hibernate.annotations.Synchronize
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Immutable
@Subselect("SELECT d.ID_DIRECTOR as id, d.NAME_DIRECTOR as name, d.SURNAME_DIRECTOR as surname, count(f.ID_FILM) as film_count "
        + "FROM DIRECTOR_ENTITY d LEFT JOIN FILM_ENTITY f ON d.ID_DIRECTOR = f.DIRECTOR_FILM_ID_DIRECTOR "
        + "GROUP BY d.ID_DIRECTOR, d.NAME_DIRECTOR")
@Synchronize("FILM_ENTITY", "DIRECTOR_ENTITY")
data class ViewCount (
    @Id val id:Long = 0,
    @Column val name: String = "",
    @Column val surname: String = "",
    @Column val film_count: Int = 0
)