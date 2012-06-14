package com.sivalabs.jforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.jforum.entities.Link;

/**
 * @author skatam
 *
 */
public interface LinkRepository extends JpaRepository<Link, Integer>
{

}
