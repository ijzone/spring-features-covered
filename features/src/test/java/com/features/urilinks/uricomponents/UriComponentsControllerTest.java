package com.features.urilinks.uricomponents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class UriComponentsControllerTest {

	/**
	 * @category URI redirect
	 * 페이지 리다이렉트 시, 쿼리파라미터를 여러개 넘겨줘야 할 때 유용
	 * TODO 추후 다른 방식도 추가 테스트 할 것.
	 */
	@Test
	void 쿼리파라미터_생성_테스트() {
		String uri = UriComponentsBuilder
				.fromPath("")
				.queryParam("pageNum", 1)
				.queryParam("amount", 10000)
				.queryParam("type", "typeA")
				.queryParam("keyword", "keywordA")
				.toUriString();
		log.info("uri: {}", uri);

		assertThat(uri).isEqualTo("?pageNum=1&amount=10000&type=typeA&keyword=keywordA");
	}

}
