package com.bsehk.business.service;

import com.bsehk.business.domain.VenueAdvert;

public interface VenueAdvertService {
    VenueAdvert selectAdvertByVenueId(Long venueId,Boolean isDelete);
}
