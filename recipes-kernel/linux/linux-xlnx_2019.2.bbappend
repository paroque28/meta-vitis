FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"                                                                                                                                                               
SRC_URI_append = " file://0001-dts-xilinx-Add-XRT-DTS.patch \
                   file://0002-xilinx-Fix-mmc0-tuning-failed-clock-error.patch \
                   "
