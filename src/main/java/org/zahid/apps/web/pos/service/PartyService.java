package org.zahid.apps.web.pos.service;

import java.util.List;
import java.util.Set;
import org.zahid.apps.web.pos.entity.Party;

public interface PartyService {

    Long generateID();

    boolean exists(Long id);

    Party findById(Long id);

    List<Party> findAll();

    Party save(Party party);

    List<Party> save(Set<Party> parties);

    void delete(Party party);

    void delete(Set<Party> parties);

    void deleteById(Long id);

    void deleteAll();

    void deleteAllInBatch();

    void deleteInBatch(Set<Party> parties);
}
