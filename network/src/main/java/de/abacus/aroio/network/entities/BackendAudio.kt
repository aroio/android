package de.abacus.aroio.network.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackendAudio(
	@SerialName("audioplayer")
	val audioPlayer: String?,
	@SerialName("channels")
	val channels: Int,
	@SerialName("soundcard")
	val soundCard: String,
	@SerialName("resampling")
	val resampling: String,
	@SerialName("volume_start")
	val volumeStart: Int,
	@SerialName("debug")
	val isDebug: Boolean,
	@SerialName("jackbuffer")
	val jackBuffer: Int,
	@SerialName("jackperiod")
	val jackPeriod: Int,
	@SerialName("raw_player")
	val rawPlayer: String,
	@SerialName("raw_playerms")
	val rawPlayerMs: String,
	@SerialName("squeeze_maxfrequency")
	val squeezeMaxFrequency: Int,
	@SerialName("squeeze_alsabuffer")
	val squeezeAlsaBuffer: Int,
	@SerialName("squeeze_alsaperiod")
	val squeezeAlsaPeriod: Int,
	@SerialName("squeeze_intbuffer")
	val squeezeIntBuffer: Int,
	@SerialName("squeeze_outbuffer")
	val squeezeOutBuffer: Int,
	@SerialName("sp_outbuffer")
	val spOutBuffer: Int,
	@SerialName("sp_period")
	val spPeriod: Int,
	@SerialName("sp_samplerate")
	val spSampleRate: Int,
	@SerialName("bf_partitions")
	val bfPartitions: Int,
	@SerialName("output_configuration")
	val outputConfiguration: BackendOutputConfiguration,
)
