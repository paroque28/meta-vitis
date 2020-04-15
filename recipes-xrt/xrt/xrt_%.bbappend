FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://0001-runtime_src-CMakeLists-support-multilib-yocto.patch"

