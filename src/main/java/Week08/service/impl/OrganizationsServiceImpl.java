package Week08.service.impl;

import Week08.model.Organization;
import Week08.repository.OrganizationsRepository;
import Week08.service.OrganizationsService;
import Week08.service.exception.RequiredFieldMissedException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record OrganizationsServiceImpl(
        OrganizationsRepository organizationsRepository) implements OrganizationsService {

    @Override
    public Organization create(Organization organization) {
        validate(organization);
        Organization createdOrganization = new Organization(
                UUID.randomUUID().toString(),
                organization.getName(),
                organization.getImage(),
                organization.getUser(),
                organization.getDirector(),
                organization.getInn(),
                organization.getOgrn(),
                organization.getKpp(),
                organization.getOkved(),
                organization.getOkpo(),
                organization.getBank(),
                organization.getBik(),
                organization.getPhone(),
                organization.getEmail(),
                organization.getEmployeesCount(),
                organization.getAddress(),
                organization.getCreationDate(),
                organization.getUpdateDate(),
                organization.getDescription()
        );
        return organizationsRepository.saveAndFlush(createdOrganization);
    }

    private void validate(Organization organization) {
        if (organization.getName() == null) throw new RequiredFieldMissedException("name");
        if (organization.getInn() == null) throw new RequiredFieldMissedException("inn");
    }
}
