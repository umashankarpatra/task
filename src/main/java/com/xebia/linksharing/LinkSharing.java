package com.xebia.linksharing;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.ForwardedHeaderFilter;

import com.xebia.linksharing.infra.config.ApplicationProperties;
import com.xebia.linksharing.model.Album;
import com.xebia.linksharing.repository.LinkRepository;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({ ApplicationProperties.class })
public class LinkSharing {

	@Autowired
	private LinkRepository albumRepository;

	public static void main(String[] args) {
		SpringApplication.run(LinkSharing.class, args);
	}

	@Bean
	ForwardedHeaderFilter forwardedHeaderFilter() {
		return new ForwardedHeaderFilter();
	}

	/*
	 * @PostConstruct private void initDb() { Album album = new Album();
	 * album.setArtist("uma"); album.setDescription("Uma is a singer");
	 * album.setTitle("album"); albumRepository.save(album); }
	 */

}
