ACLOCAL_AMFLAGS = -I m4

SUBDIRS = de.ibapl.jnhw.common de.ibapl.jnhw.posix de.ibapl.jnhw.winapi

install-jnhw-resources:
	for dir in $(SUBDIRS); do \
	  (cd $$dir && $(MAKE) install-jnhw-resources \
	done
