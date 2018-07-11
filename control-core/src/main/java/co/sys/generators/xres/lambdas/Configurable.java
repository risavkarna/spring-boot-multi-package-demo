package co.sys.generators.xres.lambdas;

import co.sys.generators.xres.System;
import co.sys.generators.xres.dto.ConfigurationDTO;

@FunctionalInterface
public interface Configurable {
	System configure(ConfigurationDTO configurationDTO);
}
