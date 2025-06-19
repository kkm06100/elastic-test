package org.example.elastictest.service;

import lombok.RequiredArgsConstructor;
import org.example.elastictest.document.UserDocument;
import org.example.elastictest.document.repository.UserSearchRepository;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSearchService {

    private final UserSearchRepository userSearchRepository;

    private final ElasticsearchOperations elasticsearchOperations;

    public List<UserDocument> searchName(String input) {

        NativeQuery query = NativeQuery.builder()
                .withQuery(builder -> builder
                        .fuzzy(f -> f
                                .field("name")
                                .value(input)
                                .fuzziness("AUTO")
                        )
                )
                .build();

        SearchHits<UserDocument> searchHits = elasticsearchOperations
                .search(query, UserDocument.class);

        return searchHits
                .getSearchHits()
                .stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }
}
