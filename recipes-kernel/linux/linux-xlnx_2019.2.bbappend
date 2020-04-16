FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"                                                                                                                                                               

SRC_URI_append = " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.4;destsuffix=kernel-meta"
SRCREV_meta ?= "bee554e595e49c963900d1c78c01ab2d041382e7"

SRC_URI_append = " file://0001-dts-xilinx-Add-XRT-DTS.patch"

